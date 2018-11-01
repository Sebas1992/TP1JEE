/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionStage.DAO;

import java.util.List;

/**
 *
 * @author sebas
 * @param <T>
 */
public interface Dao<T> {
    public boolean create(T x);
    public T find(int key);
    public T find(String key);
    public List<T> findAll();
    public boolean update(T x);
    public boolean delete(T x);
}
