package jpsave.airbnb;

import jpsave.airbnb.logements.Appartement;
import jpsave.airbnb.logements.Maison;
import jpsave.airbnb.utilisateurs.Hote;
import jpsave.airbnb.utilisateurs.Personne;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Personnes")
public class LogementsXMLFile {

    @XmlElement(name = "Personne")
    private List<Personne> personnes;

    public List<Personne> getPersonnes() {
        return personnes;
    }
}
