package br.com.recycling.controller;

import br.com.recycling.exception.FieldValueNotInformed;
import br.com.recycling.exception.MinimumAmountOfFieldNotReported;
import br.com.recycling.model.ChangeDAO;
import br.com.recycling.model.ConsultDAO;
import java.util.ArrayList;

/**
 *
 * @author Fabio Cassimiro
 */
public class ControllerRecycling {

    private ConsultDAO consultDAO = new ConsultDAO();
    private ChangeDAO changeDAO = new ChangeDAO();
    public static ArrayList<String> finalValues = new ArrayList<>();
    private int quantity;

    public void Recycling(String item, String quantity) throws FieldValueNotInformed {
        finalValues = consultDAO.valuesItem(item);
        this.quantity = Integer.parseInt(quantity);
        finalValues.set(2, calcScore());
        finalValues.set(3, calcTime());
        changeDAO.updateScore("SCORE", newScore());

    }

    public void validValue(String amout) throws MinimumAmountOfFieldNotReported {
        if (amout.equals("0")) {
            throw new MinimumAmountOfFieldNotReported("Unreported quantity");
        }
    }

    public void validItem(String item) throws FieldValueNotInformed {
        if (item.equals("Select Item")) {
            throw new FieldValueNotInformed("Unreported item");
        }
    }
    
    public String calcScore() {
        return String.valueOf(Integer.parseInt(ConsultDAO.values.get(2)) * quantity);
    }

    public String calcTime() {
        if (ConsultDAO.values.get(3).equals("Indeterminado")) {
            return "Indeterminado";
        } else {
            return String.valueOf(Integer.parseInt(ConsultDAO.values.get(3)) * quantity);
        }
    }
    
    public String newScore() {
        return String.valueOf(Integer.parseInt(finalValues.get(2)) + Integer.parseInt(ConsultDAO.consultScore()));
    }

}
