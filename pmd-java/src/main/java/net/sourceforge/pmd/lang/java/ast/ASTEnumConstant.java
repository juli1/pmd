/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
/* Generated By:JJTree: Do not edit this line. ASTEnumConstant.java */

package net.sourceforge.pmd.lang.java.ast;

import net.sourceforge.pmd.lang.java.qname.JavaTypeQualifiedName;


public class ASTEnumConstant extends AbstractJavaNode implements JavaQualifiableNode {

    private JavaTypeQualifiedName qualifiedName;

    public ASTEnumConstant(int id) {
        super(id);
    }

    public ASTEnumConstant(JavaParser p, int id) {
        super(p, id);
    }

    /**
     * Accept the visitor. *
     */
    @Override
    public Object jjtAccept(JavaParserVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }


    /**
     * Gets the qualified name of the anonymous class
     * declared by this node, or null if this node
     * doesn't declare any.
     *
     * @see #isAnonymousClass()
     */
    @Override
    public JavaTypeQualifiedName getQualifiedName() {
        return qualifiedName;
    }


    public void setQualifiedName(JavaTypeQualifiedName qname) {
        this.qualifiedName = qname;
    }


    /**
     * Returns true if this enum constant defines a body,
     * which is compiled like an anonymous class. If this
     * method returns false, then {@link #getQualifiedName()}
     * returns {@code null}.
     */
    public boolean isAnonymousClass() {
        return getFirstChildOfType(ASTClassOrInterfaceBody.class) != null;
    }

}
