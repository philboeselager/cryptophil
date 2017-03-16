package containers;

/**
 * Created by philboeselager on 12.11.16.
 */
public interface CharSet {

    String getEncoded(final Character aChar);

    Character getDecoded(final String aEncoded);

}
