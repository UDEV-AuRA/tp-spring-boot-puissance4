package Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import com.igs.ipi.tpspringbootsalyndiaye.modele.GameModele;

@Component
@Scope(value ="session", proxyMode = ScopedProxyMode.TARGET_CLASS)

public class PartieEnCours {

	@Autowired
	public GameModele gameModele;

	public GameModele getGameModele(GameModele gameModele) {
		return gameModele;
	}

	public void setGameModele(GameModele gameModele) {
		this.gameModele = gameModele;
	}
	
	
	
}
