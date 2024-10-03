import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;

public class JavaParserExample {

    public static void main(String[] args) throws IOException {
        String rootDirectory = "path/to/your/java/project";
        parseJavaFiles(rootDirectory);
    }

    public static void parseJavaFiles(String rootDirectory) throws IOException {
        Files.walkFileTree(Paths.get(rootDirectory), EnumSet.noneOf(FileVisitOption.class), Integer.MAX_VALUE,
                new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path filePath, BasicFileAttributes attrs) throws IOException {
                        if (filePath.toString().endsWith(".java")) {
                            parseJavaFile(filePath.toString());
                        }
                        return FileVisitResult.CONTINUE;
                    }
                });
    }

    public static void parseJavaFile(String filePath) {
        try {
            CompilationUnit cu = StaticJavaParser.parse(new File(filePath));

            System.out.println("Package: " + cu.getPackageDeclaration().map(pd -> pd.getName().asString()).orElse(""));

            new ClassVisitor().visit(cu, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClassVisitor extends VoidVisitorAdapter<Void> {
        @Override
        public void visit(TypeDeclaration<?> type, Void arg) {
            super.visit(type, arg);

            System.out.println("Class: " + type.getName());

            type.getMethods().forEach(method -> {
                System.out.println("Method: " + method.getDeclarationAsString());
                method.getBody().ifPresent(body -> body.accept(new MethodInvocationVisitor(), null));
            });

            type.getFields().forEach(field -> System.out.println("Field: " + field.getDeclarationAsString()));
        }
    }

    private static class MethodInvocationVisitor extends VoidVisitorAdapter<Void> {
        @Override
        public void visit(com.github.javaparser.ast.stmt.MethodCallExpr n, Void arg) {
            super.visit(n, arg);
            System.out.println("Invoked Method: " + n.getName());
        }
    }
}
