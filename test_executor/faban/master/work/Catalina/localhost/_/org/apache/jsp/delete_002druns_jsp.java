package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.sun.faban.harness.common.Config;
import com.sun.faban.harness.engine.RunQ;
import com.sun.faban.harness.security.AccessController;
import java.io.Reader;

public final class delete_002druns_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"error.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\">\n");
      out.write("<!--\n");
      out.write("/* The contents of this file are subject to the terms\n");
      out.write(" * of the Common Development and Distribution License\n");
      out.write(" * (the License). You may not use this file except in\n");
      out.write(" * compliance with the License.\n");
      out.write(" *\n");
      out.write(" * You can obtain a copy of the License at\n");
      out.write(" * http://www.sun.com/cddl/cddl.html or\n");
      out.write(" * install_dir/legal/LICENSE\n");
      out.write(" * See the License for the specific language governing\n");
      out.write(" * permission and limitations under the License.\n");
      out.write(" *\n");
      out.write(" * When distributing Covered Code, include this CDDL\n");
      out.write(" * Header Notice in each file and include the License file\n");
      out.write(" * at install_dir/legal/LICENSE.\n");
      out.write(" * If applicable, add the following below the CDDL Header,\n");
      out.write(" * with the fields enclosed by brackets [] replaced by\n");
      out.write(" * your own identifying information:\n");
      out.write(" * \"Portions Copyrighted [year] [name of copyright owner]\"\n");
      out.write(" *\n");
      out.write(" * $Id$\n");
      out.write(" *\n");
      out.write(" * Copyright 2005-2009 Sun Microsystems Inc. All Rights Reserved\n");
      out.write(" */\n");
      out.write("-->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      com.sun.faban.harness.webclient.UserEnv usrEnv = null;
      synchronized (session) {
        usrEnv = (com.sun.faban.harness.webclient.UserEnv) _jspx_page_context.getAttribute("usrEnv", PageContext.SESSION_SCOPE);
        if (usrEnv == null){
          usrEnv = new com.sun.faban.harness.webclient.UserEnv();
          _jspx_page_context.setAttribute("usrEnv", usrEnv, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\"/>\n");
      out.write("  <meta name=\"Author\" content=\"Ramesh Ramachandran\"/>\n");
      out.write("  <meta name=\"Description\" content=\"JSP to Delete selected runs\"/>\n");
      out.write("  <title>Delete Runs from Queue [");
      out.print( Config.FABAN_HOST );
      out.write("]</title>\n");
      out.write("  <link rel=\"icon\" type=\"image/gif\" href=\"img/faban.gif\">\n");
      out.write("  <link rel=\"stylesheet\" type=\"text/css\" href=\"/css/style.css\" />\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<br/>\n");

    String[] runs = request.getParameterValues("selected-runs");
    if((runs != null) && (runs.length > 0)) {

      out.write("\n");
      out.write("The following run/s have be removed\n");
      out.write("<br>\n");

        RunQ runQ = RunQ.getHandle();
        for(String runId : runs) {
            if (AccessController.isKillAllowed(usrEnv.getSubject(), runId)) {
                if (runQ.deleteRun(runId)) {
                    out.println("<b>" + runId + "   Done </b></br>");
                } else {
                    out.println("<b>" + runId + "   Failed </b></br>");
                }
            } else {
                out.print("<b>" + runId + "   Denied </b></br>");
            }
        }
    }
    else {

      out.write("\n");
      out.write("No Runs selected to remove\n");

    }

      out.write("\n");
      out.write("\n");
      out.write("<br/>\n");
      out.write("<br/>\n");
      out.write("<br/>\n");
      out.write("<b>");
      out.print(RunQ.getHandle().getRunDaemonStatus() );
      out.write("</b>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
