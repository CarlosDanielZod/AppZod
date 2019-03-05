/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.app.utils;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author carlos
 */
public class PrintReport {
    
    public void printReports(List list) {
        try {
            String sourceReport = "priceProduct.jasper";
            
            InputStream report = getClass().getResourceAsStream(sourceReport);
            JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(list);
            
            Map parameters = new HashMap();
            JasperPrint print = null;
            
            print = JasperFillManager.fillReport(report, parameters, ds);
            JasperViewer viewer = new JasperViewer(print, false);
            viewer.setVisible(true);
            
        } catch (JRException ex) {
            Logger.getLogger(PrintReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
