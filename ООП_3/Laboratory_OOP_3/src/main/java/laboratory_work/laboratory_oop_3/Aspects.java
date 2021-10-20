package laboratory_work.laboratory_oop_3;

import laboratory_work.laboratory_oop_3.Products.*;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class Aspects {

    private String dash = "-----------------------------------------------------";

    @Pointcut("execution(* AddToWarehouse(*))")
    private void allAddToWarehouse() {
    }

    @Before("execution(* getBefore*())")
    public void beforeGetProductAdvice(JoinPoint joinPoint) {
        System.out.println(dash);
        System.out.println("beforeGetProductAdvice: Демонстрация Advice типа Before для getBeforeProducts()");
        WriteJoinPoint(joinPoint);
        System.out.println(dash);
    }

    @AfterReturning(pointcut = "execution(* getAfterReturning*())",
            returning = "products")
    public void afterReturningGetProductAdvice(JoinPoint joinPoint, List<IPossibleToPutInWarehouse> products) {
        System.out.println(dash);
        System.out.println("afterReturningGetProductAdvice: Демонстрация Advice типа AfterReturning для getAfterReturningProducts()");
        WriteJoinPoint(joinPoint);
        System.out.println(dash);

        Product firstProduct = (Product) products.get(0);
        firstProduct.setProductName("SUPER-PUPER");
        firstProduct.setPrice(500000);
        firstProduct.setYearOfProduction(2050);
    }

    @AfterThrowing(pointcut = "execution(* getAfterThrowing*())",
            throwing = "exception")
    public void afterThrowingGetProductAdvice(JoinPoint joinPoint, Throwable exception) {
        System.out.println(dash);
        System.out.println("afterThrowingGetProductAdvice: Демонстрация Advice типа AfterThrowing для getAfterThrowingProducts()");
        System.out.println("afterThrowingGetProductAdvice: Была словлена ошибка " + exception);
        WriteJoinPoint(joinPoint);
        System.out.println(dash);
    }

    @After("execution(* getAfterFinally*(int))")
    public void afterFinallyGetProductAdvice(JoinPoint joinPoint) {
        System.out.println(dash);
        System.out.println("afterFinallyGetProductAdvice: Демонстрация Advice типа AfterFinally для getAfterFinallyProducts()");
        WriteJoinPoint(joinPoint);
        WriteArgument(joinPoint);
        System.out.println(dash);
    }

    @Around("execution(* getAround*(int))")
    public Object aroundGetProductAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println(dash);
        System.out.println("aroundGetProductAdvice: Демонстрация Advice типа Around для getAroundProducts()");
        WriteJoinPoint(joinPoint);
        WriteArgument(joinPoint);
        Object targetMethod = null;
        try {
            System.out.println(dash);
            System.out.println("aroundGetProductAdvice: Попытка получить продукт");
            targetMethod = joinPoint.proceed();
            targetMethod = new Motherboard("SUPER-PUPER", 8000000, 2077);
            System.out.println("aroundGetProductAdvice: Продукт получен");
            return targetMethod;
        }catch (Exception e){
            System.out.println("aroundGetProductAdvice: Была словлена ошибка: " + e);
            throw e;
        }finally {
            System.out.println(dash);
        }
    }


    @Before("allAddToWarehouse()")
    public void beforeAddToWarehouse(JoinPoint joinPoint) {
        System.out.println(dash);
        System.out.println("beforeAddToWarehouse: Демонстрация Advice типа Before для AddToWarehouse()");
        WriteJoinPoint(joinPoint);
        WriteArgument(joinPoint);
        System.out.println(dash);
    }


    private void WriteJoinPoint(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("method Signature = " + methodSignature);
        System.out.println("method = " + methodSignature.getMethod());
        System.out.println("return type = " + methodSignature.getReturnType());
        System.out.println("method name = " + methodSignature.getName());
    }


    private void WriteArgument(JoinPoint joinPoint) {
        Object[] arguments = joinPoint.getArgs();
        for (Object obj : arguments) {

            if (obj instanceof Product) {
                Product product = (Product) obj;

                if (obj instanceof Motherboard) {
                    System.out.println("Информация о материнской плате:" +
                            "\nМодель материнской платы: " + product.getProductName() +
                            "\nЦена: " + product.getPrice() +
                            "\nГод выпуска: " + product.getYearOfProduction()
                    );
                } else if (obj instanceof Processor) {
                    System.out.println("Информация о процессоре:" +
                            "\nМодель процессора: " + product.getProductName() +
                            "\nЦена: " + product.getPrice() +
                            "\nГод выпуска: " + product.getYearOfProduction()
                    );
                } else if (obj instanceof VideoCard) {
                    System.out.println("Информация о видеокарте:" +
                            "\nМодель видеокарте: " + product.getProductName() +
                            "\nЦена: " + product.getPrice() +
                            "\nГод выпуска: " + product.getYearOfProduction()
                    );
                }
            } else if (obj instanceof Integer) {
                int index = (Integer) obj;
                System.out.println("Индекс получемого прродукта: " + index);
            }
        }
    }
}