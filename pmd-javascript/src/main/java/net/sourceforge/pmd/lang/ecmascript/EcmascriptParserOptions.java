/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.ecmascript;

import static java.util.Arrays.asList;
import static net.sourceforge.pmd.util.CollectionUtil.associateBy;

import java.util.Objects;

import org.mozilla.javascript.Context;

import net.sourceforge.pmd.Rule;
import net.sourceforge.pmd.lang.ParserOptions;
import net.sourceforge.pmd.properties.PropertyDescriptor;
import net.sourceforge.pmd.properties.PropertyFactory;

/**
 * @deprecated Will be removed in 7.0 TODO refactor this into language versions?
 */
@Deprecated
public class EcmascriptParserOptions extends ParserOptions {

    public enum Version {
        VERSION_DEFAULT("default", Context.VERSION_DEFAULT),
        VERSION_1_0("1.0", Context.VERSION_1_0),
        VERSION_1_1("1.1", Context.VERSION_1_1),
        VERSION_1_2("1.2", Context.VERSION_1_2),
        VERSION_1_3("1.3", Context.VERSION_1_3),
        VERSION_1_4("1.4", Context.VERSION_1_4),
        VERSION_1_5("1.5", Context.VERSION_1_5),
        VERSION_1_6("1.6", Context.VERSION_1_6),
        VERSION_1_7("1.7", Context.VERSION_1_7),
        VERSION_1_8("1.8", Context.VERSION_1_8),
        VERSION_ES6("ES6", Context.VERSION_ES6);

        private final String name;
        private final int version;

        Version(String name, int version) {
            this.name = name;
            this.version = version;
        }

        public String getLabel() {
            return name;
        }

        public int getVersion() {
            return version;
        }
    }

    // Note: The UI order values are chosen to be larger than those built into
    // XPathRule.

    // These aren't converted to the new property framework
    // Do we need them anyway?

    public static final PropertyDescriptor<Boolean> RECORDING_COMMENTS_DESCRIPTOR =
        PropertyFactory.booleanProperty("recordingComments")
                       .desc("Specifies that comments are produced in the AST.")
                       .defaultValue(true)
                       .build();

    public static final PropertyDescriptor<Boolean> RECORDING_LOCAL_JSDOC_COMMENTS_DESCRIPTOR =
        PropertyFactory.booleanProperty("recordingLocalJsDocComments")
                       .desc("Specifies that JsDoc comments are produced in the AST.")
                       .defaultValue(true)
                       .build();

    public static final PropertyDescriptor<Version> RHINO_LANGUAGE_VERSION =
        PropertyFactory.enumProperty("rhinoLanguageVersion", associateBy(asList(Version.values()), Version::getLabel))
                       .desc("Specifies the Rhino Language Version to use for parsing.  Defaults to Rhino default.")
                       .defaultValue(Version.VERSION_ES6)
                       .build();

    private boolean recordingComments;
    private boolean recordingLocalJsDocComments;
    private Version rhinoLanguageVersion;

    public EcmascriptParserOptions() {
        this.recordingComments = RECORDING_COMMENTS_DESCRIPTOR.defaultValue();
        this.recordingLocalJsDocComments = RECORDING_LOCAL_JSDOC_COMMENTS_DESCRIPTOR.defaultValue();
        this.rhinoLanguageVersion = RHINO_LANGUAGE_VERSION.defaultValue();
    }

    public EcmascriptParserOptions(Rule rule) {
        this.recordingComments = rule.getProperty(RECORDING_COMMENTS_DESCRIPTOR);
        this.recordingLocalJsDocComments = rule.getProperty(RECORDING_LOCAL_JSDOC_COMMENTS_DESCRIPTOR);
        this.rhinoLanguageVersion = rule.getProperty(RHINO_LANGUAGE_VERSION);
    }

    public boolean isRecordingComments() {
        return this.recordingComments;
    }

    public void setRecordingComments(boolean recordingComments) {
        this.recordingComments = recordingComments;
    }

    public boolean isRecordingLocalJsDocComments() {
        return this.recordingLocalJsDocComments;
    }

    public void setRecordingLocalJsDocComments(boolean recordingLocalJsDocComments) {
        this.recordingLocalJsDocComments = recordingLocalJsDocComments;
    }

    public Version getRhinoLanguageVersion() {
        return this.rhinoLanguageVersion;
    }

    public void setRhinoLanguageVersion(Version rhinoLanguageVersion) {
        this.rhinoLanguageVersion = rhinoLanguageVersion;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + (recordingComments ? 1231 : 1237);
        result = prime * result + (recordingLocalJsDocComments ? 1231 : 1237);
        result = prime * result + ((rhinoLanguageVersion == null) ? 0 : rhinoLanguageVersion.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final EcmascriptParserOptions that = (EcmascriptParserOptions) obj;
        return Objects.equals(this.suppressMarker, that.suppressMarker)
                && this.recordingComments == that.recordingComments
                && this.recordingLocalJsDocComments == that.recordingLocalJsDocComments
                && this.rhinoLanguageVersion == that.rhinoLanguageVersion;
    }
}
