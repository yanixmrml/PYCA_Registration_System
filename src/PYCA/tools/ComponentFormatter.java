package PYCA.tools;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;


public class ComponentFormatter {

    public static final int IMAGE_WIDTH = 150;
    public static final int IMAGE_HEIGHT = 150;
    public static final int THUMBNAIL_WIDTH = 150;
    public static final int THUMBNAIL_HEIGHT = 150;
    public static final int LARGE_IMAGE_WIDTH = 250;
    public static final int LARGE_IMAGE_HEIGHT = 250;
    public static final String DATE_FORMAT_NOW = "yyyy-MM-dd";

    public static Image convertToActualSizeImage(Blob object) {
        return convertBlobToImage(object,IMAGE_WIDTH,IMAGE_HEIGHT);
    }

    public static Image convertToImageThumbnail(Blob object) {
        return convertBlobToImage(object,THUMBNAIL_WIDTH,THUMBNAIL_HEIGHT);
    }

    public static Image convertToLargeSizeImage(Blob object){
        return convertBlobToImage(object,LARGE_IMAGE_WIDTH,LARGE_IMAGE_HEIGHT);
    }

    private static Image convertBlobToImage(Blob object, int width, int height){
        Image photo = null;
        InputStream input;
        try {
            input = object.getBinaryStream();
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] rb = new byte[1024];
            int ch = 0;
            while ((ch = input.read(rb)) != -1) {
                output.write(rb, 0, ch);
            }
            byte[] b = output.toByteArray();
            input.close();
            output.close();
            photo = Toolkit.getDefaultToolkit().createImage(b).getScaledInstance(width, height, 100);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return photo;
    }

    public static Date formatDate(JComboBox yearCombobox, JComboBox monthCombobox, JComboBox dayCombobbox){
        String strYear = yearCombobox.getSelectedItem()+"";
        String strMonth = monthCombobox.getSelectedItem()+"";
        String strDay = dayCombobbox.getSelectedItem()+"";
        int year = 0;
        int month = 0;
        int day = 0;
        if (strMonth.equals("January")) {
            month = 1;
        } else if (strMonth.equals("February")) {
            month = 2;
        } else if (strMonth.equals("March")) {
            month = 3;
        } else if (strMonth.equals("April")) {
            month = 4;
        } else if (strMonth.equals("May")) {
            month = 5;
        } else if (strMonth.equals("June")) {
            month = 6;
        } else if (strMonth.equals("July")) {
            month = 7;
        } else if (strMonth.equals("August")) {
            month = 8;
        } else if (strMonth.equals("September")) {
            month = 9;
        } else if (strMonth.equals("October")) {
            month = 10;
        } else if (strMonth.equals("November")) {
            month = 11;
        } else if (strMonth.equals("December")) {
            month = 12;
        }

        year = Integer.parseInt(strYear)-1900;
        day = Integer.parseInt(strDay);
        month = month - 1;
        return new java.sql.Date(year, month, day);
    }

    public static String formatDateToString(JComboBox yearComboBox, JComboBox monthComboBox, JComboBox dayComboBox){
        String strYear = yearComboBox.getSelectedItem()+"";
        String strMonth = monthComboBox.getSelectedItem()+"";
        String strDay = dayComboBox.getSelectedItem()+"";
        int year = 0;
        String month = "";
        String day = "";

        if (strMonth.equals("January")) {
            month = "01";
        } else if (strMonth.equals("February")) {
            month = "02";
        } else if (strMonth.equals("March")) {
            month = "03";
        } else if (strMonth.equals("April")) {
            month = "04";
        } else if (strMonth.equals("May")) {
            month = "05";
        } else if (strMonth.equals("June")) {
            month = "06";
        } else if (strMonth.equals("July")) {
            month = "07";
        } else if (strMonth.equals("August")) {
            month = "08";
        } else if (strMonth.equals("September")) {
            month = "09";
        } else if (strMonth.equals("October")) {
            month = "10";
        } else if (strMonth.equals("November")) {
            month = "11";
        } else if (strMonth.equals("December")) {
            month = "12";
        }

        year = Integer.parseInt(strYear);
        int selDay = Integer.parseInt(strDay);
        if(selDay < 10){
            day = "0" + selDay;
        }
        return year + "-" + month + "-" + day;
    }

    public static void formatDateComboBox(JComboBox year, JComboBox month, JComboBox day){

            Object selectedDayObject = day.getSelectedItem();
            int selectedDay = 1;
            int size = 0;
            day.removeAllItems();

            if(selectedDayObject != null && !selectedDayObject.toString().equalsIgnoreCase("<All>")){
                selectedDay = Integer.parseInt(selectedDayObject.toString());
            }

            if(month.getSelectedIndex()==1){
                int leapyear = Integer.parseInt(year.getSelectedItem().toString()) - 1900;
                if((leapyear%4)==0){
                    size = 29;
                } else{
                    size = 28;
                }
            } else if(month.getSelectedIndex()%2==0){
                size = 31;
            } else {
                size = 30;
            }

            for(int i=0;i<size;i++){
                day.addItem(i+1);
            }

            while(selectedDay > size){
                selectedDay--;
            }
            day.setSelectedItem(selectedDay);

    }

    public static void formatDateNoToWord(Date date, JComboBox yearComboBox, JComboBox monthComboBox, JComboBox dayComboBox){
        Object yyyy = date.getYear()+1900;
        Object mm = date.getMonth()+1;
        Object dd = date.getDate();
        String month = new String();

        if (mm.equals(1)) {
            month = "January";
        } else if (mm.equals(2)) {
            month = "February";
        } else if (mm.equals(3)) {
            month = "March";
        } else if (mm.equals(4)) {
            month = "April";
        } else if (mm.equals(5)) {
            month = "May";
        } else if (mm.equals(6)) {
            month = "June";
        } else if (mm.equals(7)) {
            month = "July";
        } else if (mm.equals(8)) {
            month = "August";
        } else if (mm.equals(9)) {
            month = "September";
        } else if (mm.equals(10)) {
            month = "October";
        } else if (mm.equals(11)) {
            month = "November";
        } else if (mm.equals(12)) {
            month = "December";
        }
        yearComboBox.setSelectedItem(yyyy);
        monthComboBox.setSelectedItem(month);
        dayComboBox.setSelectedItem(dd);
    }

    public static void setUpYear(JComboBox year, int initialYear, int gaps){
        year.removeAllItems();
        Calendar cal = Calendar.getInstance();
        int currentYear = cal.get(Calendar.YEAR);
        for(int i = initialYear; i <= (currentYear-gaps); i++){
            year.addItem(i);
        }
        year.setSelectedItem(currentYear);
    }

    public static Formatter formatMonthDateYear(Date date){
        Formatter format = new Formatter();
        format.format(" %1$tB %1$td, %1$tY\n",date);
        return format;
    }

    public static Date getDateToday() {
    //yyyy--mm--dd
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat( DATE_FORMAT_NOW );
        java.sql.Date eDate = java.sql.Date.valueOf( sdf.format( cal.getTime() ) );
        return ( eDate );
    }

    public static String formatBigDecimal(BigDecimal number){
        return String.format("$ %,.2f",number);
    }

    public static void formatYearLevel(JComboBox yearLevelComboBox, int numOfYears){
        if(numOfYears==1){
            yearLevelComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "First Year"}));
        }else if(numOfYears==2){
            yearLevelComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "First Year", "Second Year"}));
        }else if(numOfYears==3){
            yearLevelComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "First Year","Second Year","Third Year"}));
        }else if(numOfYears==4){
            yearLevelComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "First Year","Second Year","Third Year","Fourth Year" }));
        }else if(numOfYears==5){
            yearLevelComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "First Year","Second Year","Third Year","Fourth Year","Fifth Year" }));
        }else{
            yearLevelComboBox.setModel(null);
        }
    }

    public static void clearTable(DefaultTableModel tableModel){

        for(int i=tableModel.getRowCount()-1;i>=0;i--){
            tableModel.removeRow(i);
        }

    }

    public static int subtractDate(Date d1,Date d2){
        Calendar cal1 = Calendar.getInstance();
        cal1.set(Calendar.YEAR, d1.getYear()+1900);
        cal1.set(Calendar.MONTH, d1.getMonth());
        cal1.set(Calendar.DATE, d1.getDate());
        Calendar cal2 = Calendar.getInstance();
        cal2.set(Calendar.YEAR, d2.getYear()+1900);
        cal2.set(Calendar.MONTH, d2.getMonth());
        cal2.set(Calendar.DATE, d2.getDate());
        return (int)((cal1.getTimeInMillis() - cal2.getTimeInMillis())/(1000*60*60*24));
    }

    public static void setTableTextColor(JTable table){
        for (int i = 0 ; i < table.getColumnCount(); i++) {
            TableColumn tc = table.getColumnModel() .getColumn (i);
            tc.setCellRenderer(new TableCellRenderer() {
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                      TableCellRenderer renderer = table.getDefaultRenderer(table.getColumnClass(column));
                      Component comp = renderer.getTableCellRendererComponent(table, value,isSelected,hasFocus, row, column);
                      if(!hasFocus && !isSelected){
                         if(column == 0 || column == 2){
                             comp.setFont(new Font("Tahoma", 1, 12));
                             comp.setForeground(Color.DARK_GRAY);
                         }else{
                             comp.setForeground(Color.BLACK);
                         }
                      }
                      return comp;
                }
            });
       }
    }

    public static void stripTable(JTable table) {
      for (int i = 0 ; i < table.getColumnCount(); i++) {
            TableColumn tc = table.getColumnModel() .getColumn (i);
            tc.setCellRenderer(new TableCellRenderer() {
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                      TableCellRenderer renderer = table.getDefaultRenderer(table.getColumnClass(column));
                      Component comp = renderer.getTableCellRendererComponent(table, value,isSelected,hasFocus, row, column);
                      if(!hasFocus && !isSelected){
                          if(row % 2 == 1){
                               comp.setBackground(Color.lightGray);
                          }else{
                               comp.setBackground(Color.white);
                          }
                      }
                      return comp;
                }
            });
       }
    }

    public static void stripProspectusTable(JTable table) {
      for (int i = 0 ; i < table.getColumnCount(); i++) {
            TableColumn tc = table.getColumnModel() .getColumn (i);
            tc.setCellRenderer(new TableCellRenderer() {
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                      TableCellRenderer renderer = table.getDefaultRenderer(table.getColumnClass(column));
                      Component comp = renderer.getTableCellRendererComponent(table, value,isSelected,hasFocus, row, column);
                      if(!hasFocus && !isSelected){
                          if(table.getValueAt(row, 0) == ""){
                                comp.setBackground(Color.lightGray);
                          }else{
                               comp.setBackground(Color.white);
                          }
                      }
                      return comp;
                }
            });
       }
    }

    public static void colorSectionTable(JTable table) {
      for (int i = 0 ; i < table.getColumnCount(); i++) {
            TableColumn tc = table.getColumnModel() .getColumn (i);
            tc.setCellRenderer(new TableCellRenderer() {
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                      TableCellRenderer renderer = table.getDefaultRenderer(table.getColumnClass(column));
                      Component comp = renderer.getTableCellRendererComponent(table, value,isSelected,hasFocus, row, column);
                      int stat = Integer.parseInt(table.getValueAt(row, 2)+"");
                      if(!hasFocus && !isSelected){
                          switch(stat){
                              case 0:
                                    comp.setForeground(Color.BLUE);
                                    break;
                            case 1:
                                    comp.setForeground(Color.GREEN);
                                    break;
                            case 2:
                                    comp.setForeground(Color.BLACK);
                                    break;
                            case 3:
                                    comp.setForeground(Color.RED);
                                    break;
                           default: break;
                                  }
                      }
                      return comp;
                }
            });
       }
    }

     public static void colorTextInformationTable(JTable table){
        for (int i = 0 ; i < table.getColumnCount(); i++) {
            TableColumn tc = table.getColumnModel() .getColumn (i);
            tc.setCellRenderer(new TableCellRenderer() {
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                      TableCellRenderer renderer = table.getDefaultRenderer(table.getColumnClass(column));
                      Component comp = renderer.getTableCellRendererComponent(table, value,isSelected,hasFocus, row, column);
                      if(!hasFocus && !isSelected){
                         if(row == 0 || row == 9 || row == 15){
                             comp.setBackground(Color.LIGHT_GRAY);
                         }else{
                             comp.setBackground(Color.WHITE);
                         }
                         if(column == 0){
                             comp.setForeground(Color.DARK_GRAY);
                         }else{
                             comp.setForeground(Color.BLACK);
                         }
                      }
                      return comp;
                }
            });
       }
    }

     public static void colorGradeTable(JTable table){
        for (int i = 2 ; i <= 3; i++) {
            TableColumn tc = table.getColumnModel() .getColumn (i);
            tc.setCellRenderer(new TableCellRenderer() {
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                      TableCellRenderer renderer = table.getDefaultRenderer(table.getColumnClass(column));
                      Component comp = renderer.getTableCellRendererComponent(table, value,isSelected,hasFocus, row, column);
                      if(!hasFocus && !isSelected){
                         if(column == 2 || column == 3){
                             if(value.toString().equalsIgnoreCase("INC") || value.toString().equalsIgnoreCase("DRP") ||
                                     value.toString().equalsIgnoreCase("5")){
                                comp.setForeground(Color.RED);
                             }else{
                                comp.setForeground(Color.BLACK);
                             }
                         }
                      }
                      return comp;
                }
            });
       }
    }

    public static String getNumberStr(int num){
        switch(num){
            case 1: return "1st";
            case 2: return "2nd";
            case 3: return "3rd";
            default: return num+"th";
        }
    }

    public static String formatDateToString(Date dateTime){
        return String.format("%tF", dateTime );
    }

}
