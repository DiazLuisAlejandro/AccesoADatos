// src/repositorioTareasSqlite.ts
import { getDb } from "./db";
import { Tarea, IdTarea } from "./models";

export class RepositorioTareasSqlite {

  private db = getDb();

  obtenerTodas(): Tarea[] {

    const tareas=this.db.prepare("SELECT id, titulo, descripcion, completada FROM tareas").all() as Tarea[]
    // TODO: SELECT * FROM tareas
    // Pista: this.db.prepare("SELECT id, titulo, descripcion, completada FROM tareas")
    //       .all();
    return tareas;
  }

  obtenerPorId(id: IdTarea): Tarea | undefined {
      const tarea=this.db.prepare("SELECT id, titulo, descripcion, completada FROM tareas where id=?").get(id) as Tarea
    // TODO: SELECT ... WHERE id = ?
    return tarea;
  }

  crear(titulo: string, descripcion?: string): Tarea {
      const tarea=this.db.prepare("INSERT INTO tareas (titulo, descripcion, completada) VALUES (?, ?, 0)").get(titulo,descripcion) as Tarea
    // TODO:
    // 1. INSERT INTO tareas (titulo, descripcion, completada) VALUES (?, ?, 0)
    // 2. Recuperar el id generado (stmt.run().lastInsertRowid)
    // 3. Devolver la tarea completa
    return tarea;
  }

  actualizar(tarea: Tarea): Tarea | undefined {
    const tareaUpdate=this.db.prepare("UPDATE tareas SET titulo = ?, descripcion = ?, completada = ? WHERE id = ?")
        .get(tarea.titulo,tarea.descripcion,tarea.completada,tarea.id) as Tarea
    // TODO:
    // 1. UPDATE tareas SET titulo = ?, descripcion = ?, completada = ? WHERE id = ?
    // 2. Comprobar cambios (stmt.changes)
    // 3. Si no se actualiza ninguna fila, devolver undefined
    // 4. Si se actualiza, devolver la tarea
    const tareaUpdated=tareaUpdate.run(
        tareaUpdate.titulo,
        tareaUpdate.descripcion,
        tareaUpdate.completada,
        tareaUpdate.id
    )
    if (){

    }
    return tareaUpdate;
  }

  borrar(id: IdTarea): boolean {
    // TODO:
    // 1. DELETE FROM tareas WHERE id = ?
    // 2. Devolver true si se ha borrado 1 registro, false en otro caso
    throw new Error("No implementado");
  }
}