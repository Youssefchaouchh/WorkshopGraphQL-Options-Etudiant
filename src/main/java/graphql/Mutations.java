package graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import entities.Etudiant;
import entities.Option;
import repository.EtudiantBusiness;
import repository.OptionBusiness;

public class Mutations implements GraphQLMutationResolver {

    private final OptionBusiness ob;
    private final EtudiantBusiness eb;

    public Mutations(OptionBusiness ob, EtudiantBusiness eb) {
        this.ob = ob;
        this.eb = eb;
    }

    // Options - signature compatible m3a OptionBusiness mte3ek
    public boolean addOption(int codeOption, String libelle, String domaine, String responsable, int credits, int semestre, int capacite) {
        Option o = new Option(codeOption, libelle, domaine, responsable, credits, semestre, capacite);
        return ob.addOption(o);
    }

    public boolean updateOption(int codeOption, String libelle, String domaine, String responsable, int credits, int semestre, int capacite) {
        Option updated = new Option(codeOption, libelle, domaine, responsable, credits, semestre, capacite);
        return ob.updateOption(codeOption, updated); // <--- 2 parametres kima 3andek
    }

    public boolean deleteOption(int codeOption) {
        return ob.deleteOption(codeOption);
    }

    // Etudiants - compatible m3a EtudiantBusiness mte3ek
    public boolean addEtudiant(String identifiant, String nom, String prenom, int codeOption, int anneeEtude, String email) {
        Option opt = ob.getOptionByCode(codeOption);
        if (opt == null) return false;
        Etudiant e = new Etudiant(identifiant, nom, prenom, opt, anneeEtude, email);
        return eb.addEtudiant(e);
    }

    public boolean updateEtudiant(String identifiant, String nom, String prenom, int codeOption, int anneeEtude, String email) {
        Option opt = ob.getOptionByCode(codeOption);
        if (opt == null) return false;
        Etudiant updated = new Etudiant(identifiant, nom, prenom, opt, anneeEtude, email);
        return eb.updateEtudiant(identifiant, updated);
    }

    public boolean deleteEtudiant(String identifiant) {
        return eb.deleteEtudiant(identifiant);
    }
}