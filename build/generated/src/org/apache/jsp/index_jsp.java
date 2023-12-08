package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javaClasses.Product;
import javaClasses.Order;
import DataObj.ProdObj;
import java.util.List;
import javaClasses.Cart;
import java.util.ArrayList;
import javaClasses.User;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/links/header.jsp");
    _jspx_dependants.add("/links/footer.jsp");
  }

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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    List<Order> order = null;
    User auth = (User) session.getAttribute("auth");
    if(auth!=null){
        request.setAttribute("auth",auth);
    }
    
    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    List<Cart> cartProd = null;
    
    if(cart_list != null){
        ProdObj po = new ProdObj();
        cartProd = po.getCartProducts(cart_list);
        request.setAttribute("cart_list", cart_list);
        
        int total = po.getTotatPrice(cart_list);
        request.setAttribute("total", total);
    }

 
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Bill</title>\n");
      out.write("    ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css\" />\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <h1 class=\"mt-4 mb-4\">Bill</h1>\n");
      out.write("\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-md-6\">\n");
      out.write("                <h3>User Details</h3>\n");
      out.write("                <form action=\"\" method=\"post\">\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label for=\"customerName\">Customer Name:</label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"customerName\" name=\"customerName\" value=\"");
      out.print( auth.getName() );
      out.write("\" disabled>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label for=\"email\">Email:</label>\n");
      out.write("                        <input type=\"email\" class=\"form-control\" id=\"email\" name=\"email\" value=\"");
      out.print( auth.getEmail() );
      out.write("\" disabled>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label for=\"address\">Address:</label>\n");
      out.write("                        <textarea class=\"form-control\" id=\"address\" name=\"address\" disabled>");
      out.print( auth.getAddress() );
      out.write("</textarea>\n");
      out.write("                    </div>\n");
      out.write("                    <h3>Product Details</h3>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        ");

                        if(order != null){
                            for(Order o:order){
                        
      out.write("\n");
      out.write("                        <label for=\"productName\">Product Name:</label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"productName\" name=\"productName\" value=\"");
      out.print( o.getProdName()  );
      out.write("\" disabled>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label for=\"quantity\">Quantity:</label>\n");
      out.write("                        <input type=\"number\" class=\"form-control\" id=\"quantity\" name=\"quantity\" value=\"");
      out.print( o.getQuantity() );
      out.write("\" disabled>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label for=\"price\">Price:</label>\n");
      out.write("                        <input type=\"number\" class=\"form-control\" id=\"price\" name=\"price\" value=\"");
      out.print( o.getPrice() );
      out.write("\" disabled>\n");
      out.write("                    </div>\n");
      out.write("                    ");

                        }
                    }
                    
      out.write("\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-primary\">Generate Bill</button>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"col-md-6\">\n");
      out.write("                <h3>Bill Summary</h3>\n");
      out.write("                <table class=\"table\">\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>Product</th>\n");
      out.write("                            <th>Quantity</th>\n");
      out.write("                            <th>Price</th>\n");
      out.write("                            <th>Total</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                        ");

                        if(order != null){
                            for(Order o:order){
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td>");
      out.print( o.getProdName() );
      out.write("</td>\n");
      out.write("                                <td>");
      out.print( o.getQuantity() );
      out.write("<td>\n");
      out.write("                                <td>");
      out.print( o.getPrice() );
      out.write("</td>\n");
      out.write("                                <td>₹ ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ (total>0)?total:0 }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                            </tr>\n");
      out.write("                    </tbody>\n");
      out.write("                    <tfoot>\n");
      out.write("                        <tr>\n");
      out.write("                            <th colspan=\"3\" class=\"text-right\">Grand Total:</th>\n");
      out.write("                            <th>₹ ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ (total>0)?total:0 }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</th>\n");
      out.write("                        </tr>\n");
      out.write("                        ");
}
                        }
                    
      out.write("\n");
      out.write("                    </tfoot>\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
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
