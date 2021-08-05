package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class viewRequest_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("         <link rel=\"stylesheet\" href=\"css/style.css\" />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <div class=\"container\">\n");
      out.write("      <div class=\"header\">\n");
      out.write("        <h1>FPT Education System</h1>\n");
      out.write("        <h3>Teacher Control Panel</h3>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"content\">\n");
      out.write("        <div class=\"left\">\n");
      out.write("          <table>\n");
      out.write("            <tbody>\n");
      out.write("              <tr>\n");
      out.write("                <td><a href=\"#\">Login</a></td>\n");
      out.write("              </tr>\n");
      out.write("              <tr>\n");
      out.write("                <td><a href=\"#\">Home</a></td>\n");
      out.write("              </tr>\n");
      out.write("              <tr>\n");
      out.write("                <td><a href=\"#\">View Request</a></td>\n");
      out.write("              </tr>\n");
      out.write("              <tr>\n");
      out.write("                <td><a href=\"#\">Solve Request</a></td>\n");
      out.write("              </tr>\n");
      out.write("              <tr>\n");
      out.write("                <td><a>Today is: 15/06/2021</a></td>\n");
      out.write("              </tr>\n");
      out.write("            </tbody>\n");
      out.write("          </table>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"right\">\n");
      out.write("          <div class=\"view\">\n");
      out.write("            <h2>View request</h2>\n");
      out.write("            <div class=\"content_view\">\n");
      out.write("              <div class=\"header_view\">\n");
      out.write("                <span>Select department</span>\n");
      out.write("                <select style=\"margin-left: 15px\">\n");
      out.write("                  <option value=\"1\">hihi xinefefge</option>\n");
      out.write("                </select>\n");
      out.write("                <br />\n");
      out.write("                <span>or Enter request title department </span>\n");
      out.write("                <input style=\"margin: 15px\" width=\"20vw;\" type=\"text\" />\n");
      out.write("                <button style=\"margin-bottom: 15px\" type=\"submit\">View</button>\n");
      out.write("              </div>\n");
      out.write("              <table>\n");
      out.write("                <tr>\n");
      out.write("                  <td>Request title</td>\n");
      out.write("                  <td>Date created</td>\n");
      out.write("                  <td>Close created</td>\n");
      out.write("                  <td>Status</td>\n");
      out.write("                  <td>Report to</td>\n");
      out.write("                  <td>Detail</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                  <td>adgdneife fjeoifjoeijg fjoiergr</td>\n");
      out.write("                  <td>2</td>\n");
      out.write("                  <td>adgrgr</td>\n");
      out.write("                  <td>2</td>\n");
      out.write("                  <td>adgrgr</td>\n");
      out.write("                  <td><a href=\"#\">View</a></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                  <td>adgrgr</td>\n");
      out.write("                  <td>2</td>\n");
      out.write("                  <td>adgrgr</td>\n");
      out.write("                  <td>2</td>\n");
      out.write("                  <td>adgrgr</td>\n");
      out.write("                  <td><a href=\"#\">View</a></td>\n");
      out.write("                </tr>\n");
      out.write("              </table>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"footer\"></div>\n");
      out.write("    </div>\n");
      out.write("  </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
