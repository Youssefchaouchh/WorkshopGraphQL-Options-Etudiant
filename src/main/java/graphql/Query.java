package graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import entities.Etudiant;
import entities.Option;
import repository.EtudiantBusiness;
import repository.OptionBusiness;
import java.util.List;

public class Query implements GraphQLQueryResolver {

    private final OptionBusiness ob;
    private final EtudiantBusiness eb;

    public Query(OptionBusiness ob, EtudiantBusiness eb) {
        this.ob = ob;
        this.eb = eb;
    }

    public List<Option> getAllOptions() {
        return ob.getListeOptions();
    }

    public List<Option> getOptionsByDomaine(String domaine) {
        return ob.getOptionsByDomaine(domaine);
    }

    public Option getOptionByCode(int codeOption) {
        return ob.getOptionByCode(codeOption);
    }

    public List<Etudiant> getAllEtudiants() {
        return eb.getAllEtudiants(); // <--- hethi li kenet ne9sa
    }

    public Etudiant getEtudiantByIdentifiant(String identifiant) {
        return eb.getEtudiantByIdentifiant(identifiant);
    }

    public List<Etudiant> getEtudiantsByOption(int codeOption) {
        Option opt = ob.getOptionByCode(codeOption);
        if (opt == null) {
            opt = new Option();
            opt.setCodeOption(codeOption);
        }
        return eb.getEtudiantsByOption(opt);
    }
}