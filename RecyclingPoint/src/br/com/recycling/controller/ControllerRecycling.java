
package br.com.recycling.controller;

import br.com.recycling.exception.FieldValueNotInformed;
import br.com.recycling.exception.MinimumAmountOfFieldNotReported;
import br.com.recycling.model.ChangeDAO;
import br.com.recycling.model.ConsultDAO;
import java.util.ArrayList;

/**
 *
 * @author WINDOWS
 */
public class ControllerRecycling {
    
    ConsultDAO consultDAO = new ConsultDAO();
    ChangeDAO changeDAO = new ChangeDAO();
    public static ArrayList<String> finalValues = new ArrayList<>();
    int amount;
    
    public void Recycling(String item, String amount) throws FieldValueNotInformed{
        finalValues = consultDAO.valuesItem(item);
        this.amount = Integer.parseInt(amount);
        finalValues.set(2, calcScore());
        finalValues.set(3, calcTime());
        changeDAO.updateScore("SCORE", calcScore());
        
    }
    
    public void validValue(String amout)throws MinimumAmountOfFieldNotReported{
        if(amout.equals("0")){
            throw new MinimumAmountOfFieldNotReported("Unreported quantity");
        }
    }
    
    public void validItem(String item) throws FieldValueNotInformed{
        if(item.equals("Select Item")){
            throw new FieldValueNotInformed("Unreported item");
        }
    }
    

    
    
    
    public String calcScore(){
        return String.valueOf(Integer.parseInt(ConsultDAO.values.get(2))* amount);
    }
    
    public String calcTime(){
        if(ConsultDAO.values.get(3).equals("Indeterminado")){
            return "Indeterminado";
        }else{
            return String.valueOf(Integer.parseInt(ConsultDAO.values.get(3))* amount);
        }
    }
    
    
}
