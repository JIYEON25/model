/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.80
 * Generated at: 2023-09-21 02:26:42 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.fileupload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class fileSelect_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {


	public String getParam(HttpServletRequest request, String paramName) {
		if(request.getParameter(paramName) != null) {
			return request.getParameter(paramName);
		} else {
			return "";
		}
	}

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');

	request.setCharacterEncoding("UTF-8");
	int filecounter = 0;
	if(request.getParameter("addcnt") != null) {
		filecounter = Integer.parseInt(request.getParameter("addcnt"));
	}

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("	<meta charset=\"UTF-8\">\r\n");
      out.write("	<title>File Select Page</title>\r\n");
      out.write("	<link href=\"style.css\" type=\"text/css\" rel=\"stylesheet\">\r\n");
      out.write("	<script type=\"text/javascript\">\r\n");
      out.write("		function inputValue(form1, param, form2, idx) {\r\n");
      out.write("			var paramValue = form1.elements[idx].value;\r\n");
      out.write("			form2.elements[idx].value = paramValue;\r\n");
      out.write("			return;\r\n");
      out.write("		}\r\n");
      out.write("		function addFile(formName) {\r\n");
      out.write("			if(formNAme.addcnt.value == \"\") {\r\n");
      out.write("				alert(\"Put the number of files you'll upload and press the submit button.\");\r\n");
      out.write("				formName.addcnt.focus();\r\n");
      out.write("				return;\r\n");
      out.write("			}\r\n");
      out.write("			formName.submit();\r\n");
      out.write("		}\r\n");
      out.write("		function elementCheck(formName) {\r\n");
      out.write("			paramIndex = 1;\r\n");
      out.write("			for(idx=0; idx<formName.elements.length; idx++) {\r\n");
      out.write("				if(formName.elements[idx].type == \"file\") {\r\n");
      out.write("					if(formNAme.elements[idx].value == \"\") {\r\n");
      out.write("						var message = paramIndex + \"번째 파일 정보가 누락되었습니다.\\n업로드할 파일을 선택해주세요.\";\r\n");
      out.write("						alert(message);\r\n");
      out.write("						formName.elements[idx].focus();\r\n");
      out.write("						return;\r\n");
      out.write("					}\r\n");
      out.write("					paramIndex++;\r\n");
      out.write("				}\r\n");
      out.write("			}\r\n");
      out.write("			formName.action = \"fileView.jsp\";\r\n");
      out.write("			formName.submit();\r\n");
      out.write("		}\r\n");
      out.write("	</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body topmargin=\"100\">\r\n");
      out.write("	<div align=\"center\">\r\n");
      out.write("		<font color=\"#0000ff\" size=\"2\">\r\n");
      out.write("			복수개의 파일의 업로드를 위하여 파일 갯수를 입력한 후<br>\r\n");
      out.write("			확인 버튼을 눌러주세요!!<br>\r\n");
      out.write("			입력이 완료되면 DONE 버튼을 눌러주세요\r\n");
      out.write("		</font>\r\n");
      out.write("	</div><br>\r\n");
      out.write("	<form name=\"formName1\" method=\"post\">\r\n");
      out.write("		<table width=\"75%\" border=\"1\" align=\"center\" cellpadding=\"1\" cellspacing=\"1\" bordercolor=\"#660000\" bgcolor=\"#FFFF99\">\r\n");
      out.write("			<tr bgcolor=\"#FFCC00\">\r\n");
      out.write("				<td width=\"10%\">\r\n");
      out.write("					<div align=\"right\">user</div>\r\n");
      out.write("				</td>\r\n");
      out.write("				<td><input type=\"text\" name=\"user\" \r\n");
      out.write("					 onkeyup=\"inputValue(this.form,user,formName2,0)\" value=\"");
      out.print(getParam(request,"user") );
      out.write("\"></td>\r\n");
      out.write("				<td width=\"10%\">\r\n");
      out.write("					<div align=\"right\">title</div>\r\n");
      out.write("				</td>\r\n");
      out.write("				<td><input type=\"text\" name=\"title\" \r\n");
      out.write("					 onkeyup=\"inputValue(this.form,title,formName2,1)\" value=\"");
      out.print(getParam(request,"title") );
      out.write("\">\r\n");
      out.write("				</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr bgcolor=\"#FFCC00\">\r\n");
      out.write("				<td width=\"15%\">\r\n");
      out.write("					<div align=\"right\">Abstract</div>\r\n");
      out.write("				</td>\r\n");
      out.write("				<td width=\"50%\" colspan=\"3\">\r\n");
      out.write("					<textarea name=\"abstract\" cols=\"40\" onkeyup=\"inputValue(this.form,abstract,formName2,2)\"></textarea>\r\n");
      out.write("				</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<td colspan=\"4\">\r\n");
      out.write("					<div align=\"center\">\r\n");
      out.write("						<font size=\"-2\">추가할 파일 수 입력</font>\r\n");
      out.write("							<input type=\"text\" name=\"addcnt\">\r\n");
      out.write("							<input type=\"button\" value=\"확인\" onClick=\"addFile(this.form)\">\r\n");
      out.write("					</div>\r\n");
      out.write("				</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("		</table>\r\n");
      out.write("	</form>\r\n");
      out.write("	<form name=\"formName2\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("		<table width=\"75%\" border=\"1\" align=\"center\" cellpadding=\"1\" cellspacing=\"1\" bordercolor=\"#660000\" bgcolor=\"#FFFF99\">\r\n");
      out.write("			<tr bgcolor=\"FFCC00\">\r\n");
      out.write("				<td width=\"40%\">\r\n");
      out.write("					<input type=\"hidden\" name=\"txtUser\" value=\"");
      out.print(getParam(request,"user") );
      out.write("\">\r\n");
      out.write("					<input type=\"hidden\" name=\"txtTitle\" value=\"");
      out.print(getParam(request,"title") );
      out.write("\">\r\n");
      out.write("					<input type=\"hidden\" name=\"txtAbstract\" value=\"");
      out.print(getParam(request,"abstract") );
      out.write("\">\r\n");
      out.write("				");

					for(int i=0; i<filecounter; i++) {
				
      out.write("\r\n");
      out.write("					<input type=\"file\" size=\"50\" name=\"selectFile");
      out.print(i );
      out.write("\"><br>\r\n");
      out.write("				");

					}
				
      out.write("\r\n");
      out.write("				</td>\r\n");
      out.write("				<td>\r\n");
      out.write("					<input type=\"button\" value=\"DONE\" onClick=\"elementCheck(this.form)\">\r\n");
      out.write("				</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("		</table>\r\n");
      out.write("	</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
