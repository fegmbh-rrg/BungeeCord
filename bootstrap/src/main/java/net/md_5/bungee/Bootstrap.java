package net.md_5.bungee;

public class Bootstrap
{
    public static void main(String[] args) throws Exception
    {
        if ( Float.parseFloat( System.getProperty( "java.class.version" ) ) < 61.0 )
        {
            System.err.println( "*** ERROR *** BungeeCord requires Java 17 or above to function! Please download and install it!" );
            System.out.println( "You can check your Java version with the command: java -version" );
            return;
        }

        while (true)
        {
            try
            {
                BungeeCord.isRestarting = false;
                
                BungeeCordLauncher.main( args );
                
                waitForShutdown();
            }
            catch (RestartSignalException e)
            {
                System.out.println( "[Bootstrap] Restart-Signal empfangen. Bereite Re-Bootstrapping vor..." );
                prepareForReboot();
            }
            catch (Exception e)
            {
                System.err.println( "[Bootstrap] Unerwarteter Fehler im Lebenszyklus:" );
                e.printStackTrace();
                System.exit(1);
            }
        }
    }

    private static void waitForShutdown()
    {
        try
        {
            while (BungeeCord.getInstance() != null)
            {
                Thread.sleep(250);
            }
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
    }

    private static void prepareForReboot()
    {
        System.gc();
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException ignored) {}
    }
}
