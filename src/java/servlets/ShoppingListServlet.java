package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 784564
 */
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        callMethod(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        callMethod(request, response);
    }

    protected void callMethod(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        if (username == null) {
           
            username = request.getParameter("username");
        } 
        
        ArrayList<String> itemlist = (ArrayList<String>) session.getAttribute("list");
        
        if (itemlist == null) 
        {
            itemlist = new ArrayList();
        } 

        String actionbtn = request.getParameter("action");
        if (actionbtn == null) {
            actionbtn = "";
        } 

        //button actions
        if(actionbtn.equals("register"))
        {
            session.setAttribute("username", request.getParameter("username"));
            session.setAttribute("username", username);
            
        }
        else if(actionbtn.equals("logout"))
        {
            //remove session
                session.removeAttribute("username");
                session.invalidate();
                //get the message when the user logged out
                String msg = "You successfully logged out";
                request.setAttribute("message", msg);
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                return; 
       }
        else if(actionbtn.equals("add"))
        {
            itemlist.add(request.getParameter("item"));
            session.setAttribute("list", itemlist);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;             
        }
        else if(actionbtn.equals("delete"))
        {
            //when the user clicks delete button without selecting, then it shows error without this exception
           try 
           {
               //parameter"item" is from the name of the radio button
                String item = request.getParameter("items");
                int countItem = Integer.parseInt(item);
                itemlist.remove(countItem - 1);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                return; 
                
           } 
           catch (NumberFormatException e) 
           {}

        }


        
        if (username == null||username.equals("")) 
        {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        } 
        else 
        {
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        }
   
        
    }

}
