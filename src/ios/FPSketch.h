#import <Cordova/CDV.h>
@class ECS189DrawingViewController;
@interface FPSketch : CDVPlugin

- (void) startSketch:(CDVInvokedUrlCommand*)command;
@property (strong, nonatomic) CDVPluginResult * result;
-(NSArray*) returnSketchArray;
@property (weak, nonatomic) ECS189DrawingViewController * fullScreen;
@property (strong, nonatomic) NSString  * callbackId ;
-(void)finish;

@end