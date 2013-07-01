/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package PYCA.tools;

import PYCA.gui.PrintPreviewReports;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.JPanel;

/**
 *
 * @author yanix_mrml
 */
public class PrinterReports implements Printable, ActionListener {

    JPanel printedPanel;
    private Paper paper;
    private int numberOfPages = 0;
    private PrintPreviewReports previewReport;

    public PrinterReports(PrintPreviewReports previewReport,int numberOfPages) {
        this.previewReport = previewReport;
        this.numberOfPages = numberOfPages;
        paper = new Paper();
        paper.setSize(640, 850);
        paper.setImageableArea(14, 14, 600,800);
    }
   

    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex >= numberOfPages) { /* We have only one page, and 'page' is zero-based */
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D)graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        
        /* Now print the window and its visible contents */
        previewReport.getPrintablePanelByPage(pageIndex + 1).printAll(graphics);

        /* tell the caller that this page is part of the printed document */
        return PAGE_EXISTS;
    }

    public void actionPerformed(ActionEvent e) {
        PrinterJob job = PrinterJob.getPrinterJob();
        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();

        boolean ok = job.printDialog(aset);
        PageFormat pf = job.getPageFormat(aset);
        pf.setPaper(paper);

        job.setPrintable(this,pf);

        if (ok) {
            try {
                job.print();
            } catch (PrinterException ex) {
                System.out.println(ex);
            }
        }
    } // end method
}
