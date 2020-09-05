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

import static java.nio.charset.StandardCharsets.UTF_8;

@WebServlet(urlPatterns = "/rest/articles/*")
public class ArticlesServlet extends HttpServlet {
    private ArticleService articleService = new ArticleService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String pathInfo = req.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            final List<TbArticle> articles = articleService.getArticles();
            sendAsJson(articles, resp);
        } else {
            //można w try integera wrzucić zeby obsłużyć wyjątek jak wpisze się article/5eornbreo -> wtedy wychodzi błąd 500!!!
            //w trycatch mozna to ogarnąć
            final String articleId = pathInfo.replace("/", "");
            final TbArticle article = articleService.getArticleById(Integer.parseInt(articleId));
            sendAsJson(article, resp);
        }
    }

    private void sendAsJson(Object models, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding(UTF_8.name());
        final Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        final String jsonString = gson.toJson(models);
        final PrintWriter writer = response.getWriter();
        writer.print(jsonString);
        writer.flush();
    }
}
