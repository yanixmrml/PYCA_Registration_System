/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package PYCA.tools;

import java.util.Calendar;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import javax.swing.SwingUtilities;

/**
 *
 * @author yanix_mrml
 */
public class TimeRunnableObject implements Runnable{

    private Lock lockObject;
    private javax.swing.JLabel dateTimeLabel;
    private Condition suspend; // used to suspend and resume thread
    private boolean suspended = false;
    private Calendar dateTime;
    private static final int DELAY = 1000;

    public TimeRunnableObject( Lock theLock, javax.swing.JLabel dateTimeLabel, Calendar dateTime){
        this.dateTimeLabel = dateTimeLabel;
        this.lockObject = theLock;
        this.dateTime = dateTime;
        suspend = lockObject.newCondition();
    }

     public void run()
     {

            // get name of executing thread
         while ( true ) // infinite loop; will be terminated from outside
         {

            callInvokeLater();

         }

    }

     private void callInvokeLater(){

         try
           {
              // sleep for up to 1 second
              Thread.sleep( DELAY );

             lockObject.lock(); // obtain the lock
              try
              {
                 while ( suspended ) // loop until not suspended
                 {
                    suspend.await(); // suspend thread execution
                } // end while
              } // end try
              finally
             {
                 lockObject.unlock(); // unlock the lock
             } // end finally
          } // end try
           // if thread interrupted during wait/sleep
          catch ( InterruptedException exception )
           {
             exception.printStackTrace(); // print stack trace
           } // end catch

         SwingUtilities.invokeLater(
             new Runnable()
             {
                // pick random character and display it
                public void run()
                {
                   dateTime.add(Calendar.SECOND, 1);
                   dateTimeLabel.setText("Date : " + String.format("%1$tA, %1$tB %1$td, %1$tY   %tr", dateTime));
                 } // end method run
              } // end inner class
           );
     }
    // change the suspended/running state
     public void toggle()
     {
        suspended = !suspended; // toggle boolean controlling state

        // change label color on suspend/resume
      // output.setBackground( suspended ? Color.RED : Color.GREEN );
        lockObject.lock(); // obtain lock
       try
        {
           if ( !suspended ) // if thread resumed
          {
              suspend.signal(); // resume thread
           } // end if
        } // end try
        finally
        {
          lockObject.unlock(); // release lock
        } // end finally
     } // end method toggle

}
