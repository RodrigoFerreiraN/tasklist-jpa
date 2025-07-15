package infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

public class DAO <E>{
	private static EntityManagerFactory emf;
	protected EntityManager em;
	private Class<E> classe;
	
	static {
		try {
			emf = Persistence.createEntityManagerFactory("task-list-jpa");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public DAO() {
		this(null);
	}
	
	public DAO(Class<E> classe) {
		this.classe = classe;
		em = emf.createEntityManager();
	}
	
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public DAO<E> abrirT(){
		em.getTransaction().begin();
		return this;
	}
	
	public DAO<E> fecharT(){
		em.getTransaction().commit();
		return this;
	}
	
	public DAO<E> detachT(Class<E> classe){
		this.classe = classe;
		em.detach(classe);
		return this;
	}
	
	public E mergeUpdate(E entidade){
		entidade = em.merge(entidade);
		return entidade;
	}
	
	public DAO<E> incluir(E entidade){
		em.persist(entidade);
		return this;
	}
	
	public DAO<E> incluirAtomico(E entidade){
		em.getTransaction().begin();
		em.persist(entidade);
		em.getTransaction().commit();		
		return this;
	}
	
	public E obterPorId(Long id){
		E entidade = em.find(classe, id);
		
		return entidade;
	}
	
	public E obterPorIdDetach(Long id) {
		E entidade = em.find(classe, id);
		em.detach(entidade);
		return entidade;
	}
	
	public List<E> obterTodos(int qtde, int deslocamento){
		String jpql = "select e from " + classe.getName() + " e";
		TypedQuery<E> query = em.createQuery(jpql, classe);
		query.setMaxResults(qtde);
		query.setFirstResult(deslocamento);
		return query.getResultList();
	}
	
	public List<E> buscaPorCampo(String nomeDoCampo, Object valor){
		String jpql = "SELECT e FROM " + classe.getSimpleName() + " e WHERE e." + nomeDoCampo + " = :valor";
		List<E>  entidade = em.createQuery(jpql, classe)
				.setParameter("valor", valor)
				.getResultList();
		return entidade;
	}
	
	public List<E> obterTodosPadrão(){
		return this.obterTodos(10, 0);
	}
	
	public void remover(Long id) {
		E entidade = em.find(classe, id);
		
		try {
			if(entidade != null) {
				em.getTransaction().begin();
				em.remove(entidade);
				em.getTransaction().commit();
			}
		} catch (PersistenceException e) {
			em.getTransaction().rollback(); //inverte a transação
			
			Throwable cause = e.getCause();
			while(cause != null) {
				if(cause instanceof org.hibernate.exception.ConstraintViolationException) {
					System.out.println("Não é possível excluir! A entidade tem outras entidades associadas.");
					return;
				}
				cause = cause.getCause();
			}
		}
	}
	
	public void fechar() {
		em.close();
	}
}
