/* Generated By:JJTree: Do not edit this line. ASTTryStatement.java */

package net.sourceforge.pmd.ast;

public class ASTTryStatement extends SimpleNode {

    private boolean hasCatch;
    private boolean hasFinally;


  public ASTTryStatement(int id) {
    super(id);
  }

  public ASTTryStatement(JavaParser p, int id) {
    super(p, id);
  }

    public void setHasCatch() {
        hasCatch = true;
    }

    public void setHasFinally() {
        hasFinally = true;
    }

    public boolean hasCatch() {
        return hasCatch;
    }

    public boolean hasFinally() {
        return hasFinally;
    }

    /**
     * Call hasCatch() before you call this method
     */
    public ASTBlock getCatchBlock() {
        return (ASTBlock)jjtGetChild(2);
    }

  /** Accept the visitor. **/
  public Object jjtAccept(JavaParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
