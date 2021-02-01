package jpsave.airbnb;

import jpsave.airbnb.logements.Appartement;
import jpsave.airbnb.logements.Maison;
import jpsave.airbnb.utilisateurs.Hote;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Logements")
public class LogementsXMLFile {

    @XmlElement(name = "Appartement")
    private List<Appartement> appartements;

    @XmlElement(name = "Maison")
    private List<Maison> maisons;

    public List<Appartement> getAppartements() {
        return appartements;
    }

    public List<Maison> getMaisons() {
        return maisons;
    }
}
