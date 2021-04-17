package br.com.alura.loja.testes;

import br.com.alura.loja.dao.CategoriaDAO;
import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CadastroDeProduto {
    public static void main(String[] args) {
        cadastrarProduto();
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDAO produtoDAO = new ProdutoDAO(em);

        Produto p = produtoDAO.buscarPorId(1l);
        System.out.println(p.getPreco());

        List<Produto> produtos = produtoDAO.buscarPorNome("Xiaomi Redmi");
        produtos.forEach(prod-> System.out.println(prod.getNome()));

    }

    public static void cadastrarProduto(){
        Categoria celulares = new Categoria("CELULAR");



        Produto celular = new Produto("Xiaomi Redmi","Muito Legal",
                new BigDecimal("800"), celulares);

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDAO produtoDao = new ProdutoDAO(em);
        CategoriaDAO categoriaDAO = new CategoriaDAO(em);


        em.getTransaction().begin();

        categoriaDAO.cadastrar(celulares);
        produtoDao.cadastrar(celular);

        em.getTransaction().commit();
        em.close();
    }
}
