package pl.sda.twitter.persistance.dao;

import org.hibernate.Session;
import pl.sda.twitter.persistance.HibernateUtil;
import pl.sda.twitter.persistance.entities.TbArticle;

import org.hibernate.query.Query;
import pl.sda.twitter.persistance.entities.TbUser;

import java.util.List;

public class ArticleDao {

    public void addNewArticle(TbUser tbUser, String content) {
        try(final Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            final TbArticle tbArticle = new TbArticle();
            tbArticle.setContent(content);
            tbArticle.setUser(tbUser);
            session.save(tbArticle);
            session.getTransaction().commit();
        }
    }

    public List<TbArticle> getArticles() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            final Query q = session.createQuery("select o from " + TbArticle.class.getName() + " o");
            session.getTransaction().commit();
            return q.getResultList();
        }
    }
}
