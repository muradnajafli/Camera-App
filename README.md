# Camera app

## Purpose: 
Get familiar with Android basics. Understand how to deal with dangerous permissions 

## Description:
Let’s imaging that we need to create app that will access camera to process camera images.
In order to use camera in the app we need to request particular permission, because access
to camera can affect user privacy and cannot be used without user notification. 

## Task: 
Your task is to request camera permission and manage user response (both accept and decline of access).
You will have basic project that works with camera. After successful grant for the camera permission,
you need to call specific method in the project to show the camera. In case permission is not granted
show toast message with text: “Camera permission required for app”.
For more details check Javadoc and TODO`s in the project.
To learn more about Toasts please follow [the link](https://developer.android.com/guide/topics/ui/notifiers/toasts)
