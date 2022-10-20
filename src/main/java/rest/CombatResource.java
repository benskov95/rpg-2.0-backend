package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.CombatDTO;
import facades.CombatFacade;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import security.errorhandling.AuthenticationException;
import utils.EMF_Creator;

@Path("combat")
public class CombatResource {
    
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    public static final CombatFacade COMBAT_FACADE = CombatFacade.getCombatFacade(EMF);
            
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public String calculatePlayerDamage(String combatInfo) throws  AuthenticationException, Exception {
        CombatDTO combatDto = GSON.fromJson(combatInfo, CombatDTO.class);
        CombatDTO resDto = COMBAT_FACADE.calculatePlayerDamage(combatDto);
        return GSON.toJson(resDto);
    }
    
}
