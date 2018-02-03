package com.nicolasf.duplicates.cache;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class RLEncoderTest {

    @Test
    public void testDifferentDataCanBeRLEEncodedAndDecoded() throws Exception {
        String text1 = "AAAABBGGGGGCCCDDDDDE";
        String encoded1 = "4A2B5G3C5D1E";

        String text2 = "ABCD";
        String encoded2 = "1A1B1C1D";

        String text3 = "AAA";
        String encoded3 = "3A";

        Assertions.assertThat("4A2B5G3C5D1E").isEqualTo(RLEncoder.encodeRL(text1));
        Assertions.assertThat("AAAABBGGGGGCCCDDDDDE").isEqualTo(RLEncoder.decodeRL(encoded1));

        Assertions.assertThat("1A1B1C1D").isEqualTo(RLEncoder.encodeRL(text2));
        Assertions.assertThat("ABCD").isEqualTo(RLEncoder.decodeRL(encoded2));

        Assertions.assertThat("3A").isEqualTo(RLEncoder.encodeRL(text3));
        Assertions.assertThat("AAA").isEqualTo(RLEncoder.decodeRL(encoded3));
    }

}