package org.owasp.esapi.core.encoding;

import org.owasp.esapi.core.SecurityComponent;
import org.owasp.esapi.core.validation.ValidationException;

/**
 * The Encoder interface provides an API for contextually output encoding untrusted data.
 *
 * // TODO: Provide lots more documentation here on using the new Encoder APIs
 *
 * @author Chris Schmidt (chris.schmidt@owasp.org) http://www.ContrastSecurity.com
 */
public interface Encoder extends SecurityComponent {


    /**
     * Encodes the given untrusted input for the supplied context.
     *
     * @param context The context to apply encoding for
     * @param input The input to be encoded
     * @param <Context> The Context Type implied by the context parameter.
     * @return
     */
    <Context extends EncodingContext> String encode(Context context, String input) throws EncodingException;

    /**
     * Canonicalization is simply the operation of reducing a possibly encoded
     * string down to its simplest form. This is important, because attackers
     * frequently use encoding to change their input in a way that will bypass
     * validation filters, but still be interpreted properly by the target of
     * the attack. Note that data encoded more than once is not something that a
     * normal user would generate and should be regarded as an attack.
     * <p>
     * Everyone <a href="http://cwe.mitre.org/data/definitions/180.html">says</a> you shouldn't do validation
     * without canonicalizing the data first. This is easier said than done. The canonicalize method can
     * be used to simplify just about any input down to its most basic form. Note that canonicalize doesn't
     * handle Unicode issues, it focuses on higher level encoding and escaping schemes. In addition to simple
     * decoding, canonicalize also handles:
     * <ul><li>Perverse but legal variants of escaping schemes</li>
     * <li>Multiple escaping (%2526 or &#x26;lt;)</li>
     * <li>Mixed escaping (%26lt;)</li>
     * <li>Nested escaping (%%316 or &%6ct;)</li>
     * <li>All combinations of multiple, mixed, and nested encoding/escaping (%2&#x35;3c or &#x2526gt;)</li></ul>
     * <p>
     * Using canonicalize is simple. The default is just...
     * <pre>
     *     String clean = encoder.canonicalize(request.getParameter("input"));
     * </pre>
     *
     * Although ESAPI is able to canonicalize multiple, mixed, or nested encoding, it's safer to not accept
     * this stuff in the first place. In ESAPI, the default is "strict" mode that throws an {@link EncodingException}
     * if it receives anything not single-encoded with a single scheme.
     * <p/>
     * Implementors can choose to allow overwriting of this default policy either by explicitly not throwing the
     * {@link EncodingException} in their implementation or by providing a means of configuring the behavior of the
     * Encoder implementation.
     *
     * @see <a href="http://www.w3.org/TR/html4/interact/forms.html#h-17.13.4">W3C specifications</a>
     *
     * @param input The input to be canonicalized
     * @return The supplied input reduced to it's simplest form.
     */
    String canonicalize(String input) throws EncodingException;

}
