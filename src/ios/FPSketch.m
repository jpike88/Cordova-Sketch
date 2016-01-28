#import "FPSketch.h"
#import "ECS189DrawingViewController.h"
@implementation FPSketch

- (void)startSketch:(CDVInvokedUrlCommand*)command
{

    _callbackId = [command callbackId];
    
    NSString* name = [[command arguments] objectAtIndex:0];
    
    ECS189DrawingViewController * fullScreen = [[ECS189DrawingViewController alloc] init];
    fullScreen.sketchView = self;
    [self.viewController presentViewController:fullScreen animated:YES completion:nil];
    _fullScreen = fullScreen;
    
    
    
    //
}

-(void)finish{

    [self success:_result callbackId:_callbackId];
    [self.viewController dismissViewControllerAnimated:YES completion:^{
        
    }];
    
}

-(NSArray*)returnSketchArray{
    return [[NSArray alloc]init];
}

@end