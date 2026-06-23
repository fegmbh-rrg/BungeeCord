package net.md_5.bungee;

/**
 * Werden von der JVM abgefangen, um einen prozessinternen Warm-Restart
 * ohne Beendigung des Betriebssystem-Prozesses einzuleiten.
 */
public class RestartSignalException extends RuntimeException
{
    public RestartSignalException()
    {
        super( "Internal proxy warm-restart triggered." );
    }
}
