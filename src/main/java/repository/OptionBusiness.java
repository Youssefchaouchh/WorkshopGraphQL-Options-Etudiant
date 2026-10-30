package repository;

import entities.Option;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OptionBusiness {
    private static List<Option> options;

    public OptionBusiness() {
        options = new ArrayList<Option>();
        // Initialisation avec quelques exemples
        options.add(new Option(1, "Informatique", "Informatique", "M. Responsable Informatique", 30, 1, 30));
        options.add(new Option(2, "Mathématiques", "Mathématiques", "Mme Responsable Mathématiques", 25, 1, 25));
        options.add(new Option(3, "Physique", "Physique", "M. Responsable Physique", 20, 2, 20));
        options.add(new Option(4, "Infographie", "Infographie", "Mme Responsable Infographie", 15, 1, 15));
        options.add(new Option(5, "Chimie", "Chimie", "M. Responsable Chimie", 20, 2, 20));
    }

    public Option getOptionByCode(int code) {
        for (Option option : options) {
            if (option.getCodeOption() == code)
                return option;
        }
        return null;
    }

    public boolean addOption(Option option) {
        if (getOptionByCode(option.getCodeOption()) != null) {
            return false;
        }
        return options.add(option);
    }

    public List<Option> getOptionsByDomaine(String domaine) {
        List<Option> liste = new ArrayList<Option>();
        for (Option option : options) {
            if (option.getDomaine().equalsIgnoreCase(domaine))
                liste.add(option);
        }
        return liste;
    }

    public List<Option> getOptionsBySemestre(int semestre) {
        List<Option> liste = new ArrayList<Option>();
        for (Option option : options) {
            if (option.getSemestre() == semestre)
                liste.add(option);
        }
        return liste;
    }

    public boolean deleteOption(int code) {
        Iterator<Option> iterator = options.iterator();
        while (iterator.hasNext()) {
            Option option = iterator.next();
            if (option.getCodeOption() == code) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public boolean updateOption(int code, Option updatedOption) {
        Option option = getOptionByCode(code);
        if (option == null) {
            return false;
        }

        // Modification sur place : les etudiants gardent une reference vers cet objet
        option.setCodeOption(updatedOption.getCodeOption());
        option.setLibelle(updatedOption.getLibelle());
        option.setDomaine(updatedOption.getDomaine());
        option.setResponsable(updatedOption.getResponsable());
        option.setCredits(updatedOption.getCredits());
        option.setSemestre(updatedOption.getSemestre());
        option.setCapacite(updatedOption.getCapacite());
        return true;
    }

    public List<Option> getListeOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        OptionBusiness.options = options;
    }
}
