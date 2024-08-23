package DAO;

import entities.Libri;

import java.util.UUID;

public class LibriDAO extends CatalogoBibliotecaDAO<Libri> {

    @Override
    protected Class<Libri> getEntityClass() {
        return Libri.class;
    }

    @Override
    protected UUID getEntityId(Libri libro) {
        return libro.getCodice_ISBN();
    }


    public void addCatalogItem(Libri libro) {
    }
}
