
package br.com.recycling.controller;

import br.com.recycling.model.ConsultDAO;
import java.util.ArrayList;

/**
 *
 * @author WINDOWS
 */
public class ControllerRecycling {
    
    ConsultDAO consultDAO = new ConsultDAO();
    public static ArrayList<String> finalValues = new ArrayList<>();
    int amount;
    

    
    public void Recycling(String item, String amount){
        finalValues = consultDAO.valuesItem(item);
        this.amount = Integer.parseInt(amount);
        finalValues.set(2, calcScore());
        finalValues.set(3, calcTime());
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
