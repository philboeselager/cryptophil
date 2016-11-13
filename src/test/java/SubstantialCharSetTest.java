import containers.SubstantialCharSet;
import helpers.FileHelpers;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by philboeselager on 12.11.16.
 */
public class SubstantialCharSetTest {

    private static String mText01;

    @BeforeClass
    public static void loadResources() throws IOException {
        mText01 = FileHelpers.fileToString("NordwindUndSonne.txt",
                Charset.forName("UTF-8"),
                SubstantialCharSetTest.class);
    }

    @Test
    public void testSimpleEncodeAndDecode() throws IOException {
        // resources
        Set<Character> reference = new HashSet<>();
        SubstantialCharSet mSubstantialCharSet = new SubstantialCharSet();
        for (int i=0; i<mText01.length(); i++){
            char c = mText01.charAt(i);
            reference.add(c);
            if (! mSubstantialCharSet.hasChar(c)) {
                mSubstantialCharSet.addChar(c);
            }
        }
        // encoding
        Set<String> encoded = new HashSet<>();
        reference.forEach(x -> encoded.add(mSubstantialCharSet.getEncoded(x)));
        // decoding
        Set<Character> redecoded = new HashSet<>();
        encoded.forEach(x -> redecoded.add(mSubstantialCharSet.getDecoded(x)));
        // check
        Assert.assertEquals(reference, redecoded);
    }
}
