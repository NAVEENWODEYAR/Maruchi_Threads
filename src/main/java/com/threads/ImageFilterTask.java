package com.threads;

/**
 * @author NaveenWodeyar
 * @date 26-Apr-2025
 */

class ImageFilterTask implements Runnable {
    private final String imageName;

    public ImageFilterTask(String imageName) {
        this.imageName = imageName;
    }

    public void run() {
        System.out.println("Applying filter to " + imageName);
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        System.out.println("Done processing " + imageName);
    }

    public static void main(String[] args) {
        String[] images = {"img1.jpg", "img2.jpg", "img3.jpg"};
        for (String img : images) {
            new Thread(new ImageFilterTask(img)).start();
        }
    }
}

