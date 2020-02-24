package com.example.socle.exceptions;

/**
 * Exception thrown when an entity is not found
 *
 * @author S.BENDRIOUE
 */
public class ElementNotFoundException extends RuntimeException {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * Constructs the exception with the necessary infos
     *
     * @param entity
     *            the entity class
     * @param id
     *            the id
     */
    public ElementNotFoundException(final Class<?> entity, final Object id) {
        super(String.format("Cannot find entity of class [%s] with id [%s]", entity.getName(), String.valueOf(id)));
    }
}
