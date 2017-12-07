import java.io.IOException;
import java.util.logging.*;

public class LogTest {


        private final static Logger logger = Logger.getLogger(LogTest.class.getName());

        public void log()
        {

            Handler fh = null;  // append is true

            try
            {
                fh = new FileHandler("/home/asimeonov/Software/log/test.log", true);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

            fh.setFormatter(new SimpleFormatter());

            logger.addHandler(fh);

            logger.setLevel(Level.FINE);

            try
            {
                throw new Exception("Simulating an exception");
            }
            catch (Exception ex)
            {
                logger.log(Level.SEVERE, ex.getMessage(), ex);
            }

            logger.info("This is a info-level message");
            logger.config("This is a config-level message");
            logger.fine("This is a fine-level message");
            logger.finer("This is a finer-level messag");
            logger.finest("This is a finest-level message");  // below the logger's level

            fh.flush();
            fh.close();

        }


}
