package br.com.app.utils;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author carlos
 */
public class Formats {
    
    
    public double desformatCurrency(String preco) {
        
        if(preco != null && !preco.equals("")) {
           String ttt1 = preco.replace("R$", " ");
           String teste1234 = ttt1.replaceAll("\\.", "");
           String ttt = teste1234.replace(",", ".");
           double dbPrice = Double.parseDouble(ttt);
                
            return dbPrice;
                
        } else {
            return 0;
          }
    }
    
    public NumberFormat getCurrencyBR() {
        Locale locale = new Locale("pt", "BR");//local moeda
        NumberFormat currencyBr = NumberFormat.getCurrencyInstance(locale);//pattern currency BR
        
        return currencyBr;
    }
}
