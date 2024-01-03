package com.ahmad.delete.repository;

import com.ahmad.delete.model.DeletedFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeletedfilesRepository extends JpaRepository<DeletedFile,Integer> {
}
