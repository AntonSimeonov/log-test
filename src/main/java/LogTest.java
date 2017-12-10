import java.io.IOException;
import java.util.logging.*;

public class LogTest
{

        private final static Logger logger = Logger.getLogger(LogTest.class.getName());

        public void log()
        {



            logger.info("This is a info-level message");
            logger.config("This is a config-level message");
            logger.fine("This is a fine-level message");
            logger.finer("This is a finer-level messag");
            logger.finest("This is a finest-level message");  // below the logger's level


        }

        public void log2()
        {
            logger.info("Info log message");
        }


        public void setLogger()
        {

            Handler fh = null;

            try
            {
                fh = new FileHandler(Constants.LOG_FILE_PATH, false);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

            fh.setFormatter(new SimpleFormatter());

            logger.addHandler(fh);
            logger.setLevel(Level.FINEST);

        }


}
