package poo.loja.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import poo.loja.modelo.Produto;
import poo.loja.util.ConnectionLojaFactory;

public class ProdutoDAO {
	
	public void insere(Produto produto) {
		Connection conn = ConnectionLojaFactory.getConnection();
		try {
			String sql = "INSERT INTO produto(codigo, nome, preco) "
					+ "VALUES (?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, produto.getId());
			ps.setString(2, produto.getNome());
			ps.setDouble(3, produto.getValor());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionLojaFactory.close(conn);
		}
	}
	
	public List<Produto> getProdutos() {
		Connection conn = ConnectionLojaFactory.getConnection();
		try {
			String sql = "SELECT * FROM produto";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Produto> produtos = new ArrayList<>();
			while (rs.next()) {
				Produto p = new Produto();
				p.setId(rs.getInt(1));
				p.setNome(rs.getString(2));
				p.setValor(rs.getDouble(3));
				produtos.add(p);
			}
			
			
			conn.close();
			return produtos;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionLojaFactory.close(conn);
		}
	}
	
	public void remover(int id) {
		Connection conn = ConnectionLojaFactory.getConnection();
		try {
			String sql = "DELETE FROM Produto WHERE codigo = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionLojaFactory.close(conn);
		}
	}
	
	public void atualizar(Produto p) {
		Connection conn = ConnectionLojaFactory.getConnection();
		try {
			String sql = "UPDATE produto SET nome=?, preco=? WHERE codigo=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p.getNome());
			ps.setDouble(2, p.getValor());
			ps.setInt(3, p.getId());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionLojaFactory.close(conn);
		}
	}
	
	public List<Produto> pesquisar(String nome) {
		Connection conn = ConnectionLojaFactory.getConnection();
		try {
			String sql = "SELECT * FROM produto WHERE nome LIKE ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+nome+"%");
			ResultSet rs = ps.executeQuery();
			List<Produto> produtos = new ArrayList<>();
			while (rs.next()) {
				Produto p = new Produto();
				p.setId(rs.getInt(1));
				p.setNome(rs.getString(2));
				p.setValor(rs.getDouble(3));
				produtos.add(p);
			}
			
			
			conn.close();
			return produtos;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionLojaFactory.close(conn);
		}
	}
	
	public List<Produto> pesquisar(Double valor, boolean opcao) {
		Connection conn = ConnectionLojaFactory.getConnection();
		try {
			List<Produto> produtos = new ArrayList<>();
			if(opcao == true) { //MAIOR
				String sql = "SELECT * FROM produto WHERE preco > ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setDouble(1, valor);
				ResultSet rs = ps.executeQuery();
				
				while (rs.next()) {
					Produto p = new Produto();
					p.setId(rs.getInt(1));
					p.setNome(rs.getString(2));
					p.setValor(rs.getDouble(3));
					produtos.add(p);
				}	
			} else { 			//MENOR
				String sql = "SELECT * FROM produto WHERE preco < ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setDouble(1, valor);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					Produto p = new Produto();
					p.setId(rs.getInt(1));
					p.setNome(rs.getString(2));
					p.setValor(rs.getDouble(3));
					produtos.add(p);
				}
			}
			conn.close();
			return produtos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionLojaFactory.close(conn);
		}
	}

}
