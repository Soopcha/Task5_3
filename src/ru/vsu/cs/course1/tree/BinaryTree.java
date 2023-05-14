package ru.vsu.cs.course1.tree;

import java.awt.Color;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Интерфейс для двоичного(бинарного) дерева с реализацияей по умолчанию различных обходов
 * дерева
 *
 * @param <T>
 */
public interface BinaryTree<T> extends Iterable<T> { //интерфейс дерева
    // наследует интерфейс Итерейбел те может быть итерируемо

    /**
     * Интерфейс для описания узла двоичного(бинарного) дерева
     *
     * @param <T>
     */
    interface TreeNode<T> extends Iterable<T> { //интерфейс узла
        // наследует интерфейс Итерейбел те может быть итерируемой
        // (те можно пройти по всем узлам поддерева)

        /**
         * @return Значение в узле дерева
         */
        T getValue();

        /**
         * @return Левое поддерево
         */
        default TreeNode<T> getLeft() {
            return null; //Null по умолчанию
        } //типо реализация, но не особо, мы её перекрывать будем

        /**
         * @return Правое поддерево
         */
        default TreeNode<T> getRight() {
            return null;
        }//типо реализация, но не особо, мы её перекрывать будем(переопределять)

        /**
         * @return Цвет узла (для рисования и не только)
         */
        default Color getColor() {
            return Color.BLACK;
        }   //цвета нужны для красно-чёрных деревьев

        /**
         * Реализация Iterable&lt;T&gt;
         *
         * @return Итератор
         */
        @Override
        default Iterator<T> iterator() {
            return BinaryTreeAlgorithms.inOrderValues(this).iterator();
        } //реализованный итератор

        /**
         * Представление поддерева в виде строки в скобочной нотации
         * (1(2,3),((3,4),),5)
         *
         * @return дерево в виде строки
         */
        default String toBracketStr() {
            return BinaryTreeAlgorithms.toBracketStr(this);
        }//это конечная реализация, эти методы переопределять не будем
    }

    /**
     * @return Корень (вершина) дерева
     */
    TreeNode<T> getRoot(); // метод возвращает вершину дерева (родительский узел)


    /**
     * Реализация Iterable&lt;T&gt;
     *
     * @return Итератор
     */
    @Override
    default Iterator<T> iterator() {
        return this.getRoot().iterator();
    }


    /**
     * реализация Представление дерева в виде строки в скобочной нотации
     *
     * @return дерево в виде строки
     */
    default String toBracketStr() {
        return this.getRoot().toBracketStr();
    }
}
