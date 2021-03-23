package models

object CountModel {

    private var count = 0

    def increaseCount(): Unit = {
        count += 1;
    }

    def getCount(): Int = {
        count
    }
}