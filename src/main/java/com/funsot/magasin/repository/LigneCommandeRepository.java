package com.funsot.magasin.repository;

import com.funsot.magasin.entities.Commande;
import com.funsot.magasin.entities.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LigneCommandeRepository extends JpaRepository<LigneCommande,Long> {

    public List<LigneCommande> findByCommande(Commande commande);

    @Query(value = "select lc from lignes_commandes lc where lc.commande_id = ?1",nativeQuery = true)
    public List<LigneCommande> getByCommandeId(long cmdid);
}
