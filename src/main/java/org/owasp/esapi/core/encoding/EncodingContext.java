package org.owasp.esapi.core.encoding;

/**
 * The basic functionality of the EncodingContext is to encode a single character to it's correct format for the
 * current Context. For example, if this implementation was meant to encode characters for HTML it would encode the {@literal<}
 * character and return the value &amp;lt;.
 *
 * @author Chris Schmidt (chris.schmidt@owasp.org) https://www.ContrastSecurity.com
 */
public interface EncodingContext {
    /**
     * Encodes a single character returning either the character itself or the encoded version of the character for the
     * current context.
     *
     * @param c The character to be encoded.
     * @return Either the character itself or the encoded representation of the character.
     * @throws UnencodableCharacterException If the supplied character cannot be encoded in the current context. An example
     *                                       could be a UTF-16 character passed into a UTF-8 encoder implementation.
     */
    String encode(char c) throws UnencodableCharacterException;

    /**
     * Decodes the supplied string
     * @param str
     * @return
     * @throws EncodingException
     */
    String decode(String str) throws EncodingException;

    /**
     * Returns the character sequence that marks the beginning of a control sequence. For example in HTML this would simply
     * return the '&amp;' character.
     *
     * @return The character or character sequence that marks the beginning of a control sequence.
     */
    String getControlSequence();

    /**
     * Returns the character or character sequence that marks the end of a control sequence. For example in HTML this would
     * simply return the ';' character.
     *
     * @return The character or character sequence that marks the end of a control sequence.
     */
    String getControlSequenceEnd();
}
