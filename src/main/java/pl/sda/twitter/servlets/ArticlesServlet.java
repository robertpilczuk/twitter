package pl.sda.twitter.servlets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pl.sda.twitter.persistance.entities.TbArticle;
import pl.sda.twitter.services.ArticleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/rest/articles/")
public class ArticlesServlet extends HttpServlet {
    private ArticleService articleService = new ArticleService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final List<TbArticle> articles = articleService.getArticles();
        sendAsJson(articles, resp);
    }

    private void sendAsJson(List models, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        final Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        final String jsonString = gson.toJson(models);
        final PrintWriter writer = response.getWriter();
        writer.print(jsonString);
        writer.flush();
    }
}
