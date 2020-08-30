package pl.sda.twitter.servlets;

import org.dom4j.tree.SingleIterator;
import pl.sda.twitter.persistance.entities.TbUser;
import pl.sda.twitter.services.ArticleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/add-article")
public class AddArticleServlet extends HttpServlet {
    private ArticleService articleService;

    @Override
    public void init() throws ServletException {
        articleService = new ArticleService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String content = req.getParameter("content");
        final HttpSession session = req.getSession();
        final TbUser user = (TbUser) session.getAttribute("user");
        articleService.addArticle(user, content);
        resp.sendRedirect("index.jsp");
    }
}
